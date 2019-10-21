# Software-Testing-PPA2

The repo title is PPA1, but we're reusing it for PPA2.

We at least managed to get Phase 1 working. That's something, right? It took us a whole week, but we did it. Unfortunately, while we managed to implement database functionality by remembering the one thing they said in the database course that we didn't have to remember, we could not figure out how to test it. We also managed to figure out how to implement the web functionality. We THINK. We can't figure out how to make Maven realize it needs to compile that file. At the very least, the project should still work if you run it in Eclipse, as before, but with the added bonus of database functionality. The web functionality, though, will almost certainly not work. It can't be compiled without Maven, and Maven doesn't know that it exists.

If we'd known PPA1 was going to balloon into this, we would've done it in Python.

The command we ran to create the CI server was docker run --rm -u root -p 8080:8080 -p 50000:50000 -v jenkins-data:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock -v "$HOME":/home jenkinsci/blueocean

The command we ran to create the database was docker run --name PPA2DB -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

The name of the database is the same as the name of the container.
