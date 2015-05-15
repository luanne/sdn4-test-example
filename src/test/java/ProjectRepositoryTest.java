/*
 * Copyright (c)  [2011-2015] "Neo Technology" / "Graph Aware Ltd."
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with separate copyright notices and license terms. Your use of the source code for these subcomponents is subject to the terms and conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 *
 */

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import project.domain.Project;
import project.repository.ProjectRepository;

/**
 * Created by luanne on 15/05/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfigurationTest.class)
@DirtiesContext
public class ProjectRepositoryTest {

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	ProjectRepository projectRepository;

	@Transactional
	@Test
	public void testAddProject() {
		Project project = new Project();
		project.setName("ProjectA");
		project.setCreationDate(new Date());
		project.setDescription("Description");
		projectRepository.save(project);
		Project addedProject = projectRepository.findProjectByName("ProjectA");
		Assert.assertNotNull("should have found something", addedProject);
		projectRepository.delete(addedProject);
	}
}
