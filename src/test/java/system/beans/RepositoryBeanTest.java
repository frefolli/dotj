package system.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RepositoryBeanTest {

	@Test
	public void testRepositoryBean() {
		List<String> packages = new ArrayList<String>();
		RepositoryBean repository = new RepositoryBean();
		
		repository.setPackages(packages);
		assertEquals(packages, repository.getPackages());
		
		try {
			repository.validate();
		} catch (InvalidRepositoryBeanException e) {
			fail("should be valid");
		}
	}

}
