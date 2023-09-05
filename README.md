# Multi UI

This is an example of how to emulate a typical use case for multiple UI classes in Vaadin 7 or 8.
The core idea is that each part has its own top-level router layout.
Each layout can set a unique top-level style name that can be targeted with basic styles and CSS variables.
`UI.getCurrent()` when used for accessing top-level application state can be replaced with e.g. `AdminLayout.getCurrent()`.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).
