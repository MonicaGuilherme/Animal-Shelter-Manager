# 🐾 Animal Shelter Manager

A work-in-progress project focused on building a management tool to help animal shelter volunteers better organize and track information about the animals in their care.

## Purpose

The goal of this application is to make it easier for shelters to:

- Store and update animal profiles (dogs, cats, etc.)
- Track medical records, adoption status, and other essential info
- Improve efficiency and reduce paper-based tracking
- Support volunteers with an intuitive and accessible interface

## Status

**In development**  
This project is still in its early stages. The current focus is on defining the structure, planning core features, and setting up the base architecture.

## Planned Tech Stack

The core technologies planned for this project are flexible enough to support both local and web-based usage:

- **Frontend**  
  JavaScript, HTML, CSS  
  I'm currently exploring **Tailwind CSS** for utility-first styling and **React** to build a responsive and scalable interface.

- **Backend**  
  Java with Spring Boot

- **Database**  
  PostgreSQL

## Deployment vs Local Use

One of the project’s key decisions is still open: whether the final product will be a **locally hosted** application or a **deployed web-based** solution.

This choice will depend on the needs and capabilities of the animal shelters using it.

**Two main approaches are being considered:**

- **Local installation**, running directly on a shelter's computer or internal network:
  - Spring Boot backend serving the app locally
  - PostgreSQL (or SQLite, if needed)
  - Optional packaging as a desktop app (e.g., with Electron)
  - Optional offline capabilities via PWA features

- **Web deployment**, accessible via browser:
  - Hosted backend (Spring Boot API)
  - Cloud-hosted PostgreSQL database
  - Frontend deployed via platforms like Netlify or Render

> The final decision will prioritize simplicity, ease of use, and the real-world context in which each shelter operates.  
> The tech stack is also subject to change depending on technical requirements and practical constraints.

## Preview

Screenshots or a live demo will be added once the basic functionality is in place.

---

> This project is both a learning journey and a real-world solution in the making.  
> Contributions, feedback, or ideas are always welcome! 🐶🐱
