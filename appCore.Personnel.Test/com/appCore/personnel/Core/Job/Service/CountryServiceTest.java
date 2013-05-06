package com.appCore.personnel.Core.Job.Service;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Job.Entity.Country;
import com.appCore.personnel.Core.Job.Service.CountryService;

public class CountryServiceTest {

	@Test
	public void testGetAll() {

		List<Country> list = new ArrayList();
		list.add(new Country());
		list.add(new Country());

		CountryService service = new CountryService();

		SessionFactory mockedSessionFactory = Mockito
				.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
		Query mockedQuery = Mockito.mock(Query.class);

		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(
				mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  Country")).thenReturn(
				mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);

		ReflectionTestUtils.setField(service, "sessionFactory",
				mockedSessionFactory);

		List<Country> countryData = service.getAll();

		org.junit.Assert.assertEquals(2, countryData.size());

		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  Country");
		verify(mockedQuery, times(1)).list();

	}

	@Test
	public void testDelete() {

		CountryService service = new CountryService();

		Country fakeCountry = new Country();

		Integer fakeParamater = 1;

		SessionFactory mockedSessionFactory = Mockito
				.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
		Query mockedQuery = Mockito.mock(Query.class);

		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(
				mockedSession);
		Mockito.when(mockedSession.get(Country.class, fakeParamater))
				.thenReturn(fakeCountry);

		ReflectionTestUtils.setField(service, "sessionFactory",
				mockedSessionFactory);

		service.delete(fakeParamater);

		verify(mockedSession).get(Country.class, fakeParamater);
		verify(mockedSession).delete(fakeCountry);

	}

	@Test
	public void testGet() {

		CountryService service = new CountryService();
		Country fakeCountry = new Country();

		Integer fakeParamater = 1;

		SessionFactory mockedSessionFactory = Mockito
				.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
		Query mockedQuery = Mockito.mock(Query.class);

		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(
				mockedSession);
		Mockito.when(mockedSession.get(Country.class, fakeParamater))
				.thenReturn(fakeCountry);

		ReflectionTestUtils.setField(service, "sessionFactory",
				mockedSessionFactory);

		// Act
		service.get(fakeParamater);

		verify(mockedSession).get(Country.class, fakeParamater);

	}

	@Test
	public void testSaveOrUpdate() {
		CountryService service = new CountryService();

		Country fakeCountry = new Country();

		SessionFactory mockedSessionFactory = Mockito
				.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
		Query mockedQuery = Mockito.mock(Query.class);

		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(
				mockedSession);

		ReflectionTestUtils.setField(service, "sessionFactory",
				mockedSessionFactory);

		service.saveOrUpdate(fakeCountry);

		verify(mockedSession).saveOrUpdate(fakeCountry);
		verify(mockedSession, times(1));
	}

}
