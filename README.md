# Documentation for Docker Compose

- To start the containers, simply run `docker-compose up` in the root directory. In detached mode, run `docker-compose up -d`.
- If you want to build the images, run `docker-compose up --build`.
- If you want to stop the containers, run `docker-compose down`.

# IMPORTANT RULES
- You can not push to the main branch, only after a pull request is approved.
- Use feature branches for your work.
- Use the following naming convention for your branches: `feature_<feature-name>`.
- Use the following naming convention for your commits: `[#<issue-number>] <commit-message>`.

## Other useful information

- If you make a pull request, it will trigger a Jenkins pipeline,
  and this will perform a SonarQube analysis on your code.
  You can check the results of the analysis on the SonarQube server: http://localhost:9000
- In the project you can use Sonar Lint to check your code before pushing it to the repository.
  Do not forget to bind it to the SonarQube server.
- Pushing or merging into production branch will also trigger a Jenkins pipeline.
  This one will deploy the application to the production server.

## Backend
- Backend ports are not exposed to the host machine.
  To access the backend, you must use the frontend.
  If you want to test your endpoints, you can locally build your Spring app.
  (In the future I will add one more container for swagger.ui, or just adding as dependency to the backend container)
-

## DB

## Frontend

Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.
