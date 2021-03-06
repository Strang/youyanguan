package com.gusteauscuter.youyanguan.data_Class.book;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class BookSearchEngine {
	
	private static final String BASE_URL = "http://202.38.232.10/opac/servlet/opac.go";
//	private static final int START_PAGE_NUM = 1;
	
	private String searchContent;
	private String searchCriteria;
	
	private int numOfPages;
	private int numOfBooks;
	private int numOfBooksPerPage;
	
	private int numOfSearchesOnThisPage = 0;
	private int numOfBooksOnThisPage;
	
	private Document doc;
	
	public int getNumOfSearchesOnThisPage(int pageNum, int numOfBooksPerSearch) {
		numOfBooksOnThisPage = (pageNum < numOfPages) ? numOfBooksPerPage : numOfBooks % numOfBooksPerPage;
		numOfSearchesOnThisPage = (int) Math.ceil((double) numOfBooksOnThisPage / numOfBooksPerSearch);
		return numOfSearchesOnThisPage;
	}
	
	public int getNumOfBooksPerPage() {
		return numOfBooksPerPage;
	}
	
	public BookSearchEngine() {
		
	}
	
	public void searchBook(String searchContent, String searchCriteria, int page) {
		this.searchContent = searchContent;
		this.searchCriteria = searchCriteria;
		doc = searchBookHelper(page);
		howMany(doc);
	}

//	public void searchBook(String searchContent, int page) throws Exception {
//		this.searchContent = searchContent;
//		this.searchCriteria = "TITLE";
//		doc = searchBookHelper(page);
//		howMany(doc);
//	}
	
	public List<ResultBook> getBooksOnPage(int pageNum) {
		List<ResultBook> resultBookLists = new ArrayList<ResultBook>();
		if (numOfBooks == 0 || pageNum > numOfPages) return null;
		Elements elements = doc.getElementsByTag("tr");
		elements.remove(0);
		for (Element element : elements) {
			ResultBook book = new ResultBook();
			book.getResultBook(element);
			resultBookLists.add(book);
		}
		return resultBookLists;
	}
	
	
	public List<ResultBook> getBooksOnPageWithBorrowInfo(int pageNum, int numOfBooksPerSearch, int ithSearch) {
		List<ResultBook> resultBookLists = new ArrayList<ResultBook>();
		if (numOfBooks == 0 || pageNum > numOfPages) return null;
		Elements elements = doc.getElementsByTag("tr");
		elements.remove(0);
		List<Element> elementLists = null;
		int start = (ithSearch - 1) * numOfBooksPerSearch;
		if (ithSearch < numOfSearchesOnThisPage) {
			elementLists = elements.subList(start, start + numOfBooksPerSearch);
		} else {
			elementLists = elements.subList(start, numOfBooksOnThisPage);
		}
		
		for (Element element : elementLists) {
			ResultBook book = new ResultBook();
			book.getResultBookWithBorrowInfo(element);
			resultBookLists.add(book);
		}
		return resultBookLists;
	}
	
	
	public int getNumOfPages() {
		return numOfPages;
	}
	
	public int getNumOfBooks() {
		return numOfBooks;
	};
	
//	public String getSearchContent() {
//		return searchContent;
//	}
//
//	public String getSearchCriteria() {
//		return searchCriteria;
//	}

	private void howMany(Document doc) {
		Elements pTag = doc.getElementsByTag("p");
		Elements fontTag = pTag.last().getElementsByTag("font");
		numOfBooks = Integer.parseInt(fontTag.get(1).text());
		numOfBooksPerPage = Integer.parseInt(fontTag.get(2).text());
		numOfPages = (int) Math.ceil((double) numOfBooks / numOfBooksPerPage);

	}
	
	private Document searchBookHelper(int pageNum) {
		String query = buildQueryString(pageNum - 1);
		String resultHtml = getQueryHtml(query);
		Document doc = Jsoup.parse(resultHtml);
		return doc;
	}
	
	private String buildQueryString(int page) {
		String queryString = "cmdACT=simple.list" + 
							 "&RDID=ANONYMOUS" + 
							 "&ORGLIB=SCUT" + 
						     "&VAL1=" + searchContent + 
						  	 "&PAGE=" + page +
							 "&FIELD1=" + searchCriteria;
		return queryString;
	}
	
	private String getQueryHtml(String query) {
		return HttpUtil.getQueryHtml(BASE_URL, query);
	}
}
