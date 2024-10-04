package com.javabackendakademisi.freelancerMatchingPlatform.service;

import com.javabackendakademisi.freelancerMatchingPlatform.entity.Project;
import com.javabackendakademisi.freelancerMatchingPlatform.exception.ResourceNotFoundException;
import com.javabackendakademisi.freelancerMatchingPlatform.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }
    public Project updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));

        project.setTitle(projectDetails.getTitle());
        project.setDescription(projectDetails.getDescription());
        // Diğer alanlar için set işlemleri...

        return projectRepository.save(project);
    }
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
        projectRepository.delete(project);
    }
}
