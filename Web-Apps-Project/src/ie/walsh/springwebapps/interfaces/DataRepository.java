package ie.walsh.springwebapps.interfaces;

import java.util.List;

import ie.walsh.springwebapps.data.ExampleData;

public interface DataRepository {
	public List<ExampleData> findData(long max, int count);
	public List<ExampleData> findExamples(long maxValue, int i);
	public ExampleData findOne(long exampleId);
	public void save(ExampleData exampleData);
}
