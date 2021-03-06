package com.quebic.searchbox.service.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quebic.searchbox.exception.SearchBoxOperationsException;
import com.quebic.searchbox.query.Query;
import com.quebic.searchbox.service.AsyncSearchBoxOperations;
import com.quebic.searchbox.service.SearchBoxOperations;
import com.quebic.searchbox.service.parallel.ParallelQueriesUtil;
import com.quebic.searchbox.service.parallel.ParallelResult;
import com.quebic.searchbox.service.parallel.QueryMap;
import com.quebic.searchbox.service.search.Page;
import com.quebic.searchbox.service.search.SearchResult;

import rx.Observable;
import rx.Single;

@Service
public class AsyncSearchBoxOperationsImpl implements AsyncSearchBoxOperations{

	private SearchBoxOperations searchBoxOperations;
	
	@Autowired
	public AsyncSearchBoxOperationsImpl(SearchBoxOperations searchBoxOperations){
		this.searchBoxOperations = searchBoxOperations;
	}
	
	@Override
	public <T> Single<Boolean> insert(T object) {
		try{
			searchBoxOperations.insert(object);
			return Single.just(true);
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<Boolean> update(T object){
		try{
			searchBoxOperations.update(object);
			return Single.just(true);
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<Boolean> save(T object){
		try{
			searchBoxOperations.save(object);
			return Single.just(true);
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<Boolean> delete(T object){
		try{
			searchBoxOperations.delete(object);
			return Single.just(true);
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<Boolean> delete(Class<T> cls, Object id){
		try{
			searchBoxOperations.delete(cls, id);
			return Single.just(true);
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> search(Class<T> cls, Query query) {
		try{
			return Single.just(searchBoxOperations.search(cls, query));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> search(Class<T> cls, Query query, Page page) {
		try{
			return Single.just(searchBoxOperations.search(cls, query, page));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}
	
	@Override
	public <T> Single<SearchResult<T>> search(Class<T> cls, String queryJson) {
		try{
			return Single.just(searchBoxOperations.search(cls, queryJson));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> search(Class<T> cls, String queryJson, Page page) {
		try{
			return Single.just(searchBoxOperations.search(cls, queryJson, page));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> search(String queryName) {
		try{
			return Single.just(searchBoxOperations.search(queryName));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> search(String queryName, Map<String, Object> inputParms) {
		try{
			return Single.just(searchBoxOperations.search(queryName, inputParms));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> search(String queryName, Map<String, Object> inputParms, Page page) {
		try{
			return Single.just(searchBoxOperations.search(queryName, inputParms, page));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> searchByField(Class<T> cls, String field, Object searchValue) {
		try{
			return Single.just(searchBoxOperations.searchByField(cls, field, searchValue));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> searchByField(Class<T> cls, String field, Object searchValue, Page page) {
		try{
			return Single.just(searchBoxOperations.searchByField(cls, field, searchValue, page));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> searchByFieldPerfix(Class<T> cls, String field, Object searchPrefix) {
		try{
			return Single.just(searchBoxOperations.searchByFieldPerfix(cls, field, searchPrefix));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> searchByFieldPerfix(Class<T> cls, String field, Object searchPrefix,
			boolean allWords) {
		try{
			return Single.just(searchBoxOperations.searchByFieldPerfix(cls, field, searchPrefix, allWords));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> searchByFieldPerfix(Class<T> cls, String field, Object searchPrefix, Page page) {
		try{
			return Single.just(searchBoxOperations.searchByFieldPerfix(cls, field, searchPrefix, page));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> searchByFieldPerfix(Class<T> cls, String field, Object searchPrefix, Page page,
			boolean allWords) {
		try{
			return Single.just(searchBoxOperations.searchByFieldPerfix(cls, field, searchPrefix, page, allWords));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> searchByFieldPattern(Class<T> cls, String field, String pattern) {
		try{
			return Single.just(searchBoxOperations.searchByFieldPattern(cls, field, pattern));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}

	@Override
	public <T> Single<SearchResult<T>> searchByFieldPattern(Class<T> cls, String field, String pattern, Page page) {
		try{
			return Single.just(searchBoxOperations.searchByFieldPattern(cls, field, pattern, page));
		}catch(SearchBoxOperationsException e){
			return Single.error(e);
		}
	}
	
	@Override
	public <T> Observable<SearchResult<T>> parallelQueries(Map<String, Map<String, Object>> parms) {
		try{
			return ParallelQueriesUtil.runForQueryParms(this, parms);
		}catch(SearchBoxOperationsException e){
			return Observable.error(e);
		}
	}

	@Override
	public Observable<ParallelResult> parallelQueries(QueryMap queryMap) {
		try{
			
			return ParallelQueriesUtil.runForQueries(this, queryMap).map(s->{
				return new ParallelResult(s.getQueryName(), s);
			});
		}catch(SearchBoxOperationsException e){
			return Observable.error(e);
		}
	}

}
