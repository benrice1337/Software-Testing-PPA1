# Software-Testing-PPA1

Java functions are typically named in camelCase, so we named our test functions testFunctionToTest, where FunctionToTest was the name of the function in the code needing testing. In the event that such a function used a helper function, said helper function was tested in the same test function (see how testBodyMassIndex() encompasses both bodyMassIndex() and bmiCalculator()).

Install instructions:
1. Download the platform-appropriate Eclipse installer from https://www.eclipse.org/downloads/
2. Run the installer. If it prompts you to install Java, download and run the appropriate Java installer from the page it links you to.
3. Open Eclipse. Instead of creating a new project, click the option that lets you import a Github repo.
4. When the wizard asks you to give the repo link, go to the "Clone or download" button on the repo's main page and copy the link it provides you.
5. When the wizard asks you to associate the repo with a project, opt to create a new project. This will take you to the new project wizard.
6. In this wizard, give the project a name and change the storage location if you don't like the default.
7. When you're done creating the project, open PPA1.java and Tests.java. If Eclipse yells at you about JUnit 5 not being in the project build, click on the link to incorporate it.
8. To run tests, go to Tests.java and click the green play button in the ribbon. To run PPA1.java, go to PPA1.java and click the green play button.

Ben - This was my first time doing unit testing and TDD. These testing frameworks feel extremely user-hostile, sending me in circles for hours trying to install JUnit until I gave up and got Eclipse, which comes with it. And even once I got it, it felt underfeatured and hard to use: most of its functions are concerned with testing objects and data structures, not primitives. At least Eclipse made running the tests easy. For a low-level project like this, unit testing and TDD felt like a chore. For a bigger project, where implementation may not be straightforward, perhaps they would feel more useful. (Don't interpret that to mean that I want you to assign a harder programming project next time, though.) The nice thing about unit testing and TDD is that they boost your code correctness like crazy, but the drawback is that it's mind-numbingly tedious to test *every little thing*, and development time gets much, much longer.
