# bitmap-transformer


## Feature Tasks
For this assignment you will be building a bitmap (.bmp) transformer CLI. It will read a bitmap in from disk, run one or more color or raster transforms and then write it out to a new file. This project will require manipulating binary data. Your solution should be composed of small tested methods that solve specific problems. Your methods should be thoughtfully named and well documented. You should run ./gradlew run --args 'input output transform' to run your application. Your bitmap transformer modules should not use any third party libraries.

## Minimum Requirements
* The CLI should be architected using best modularization practices.
* The CLI should contain a Bitmap class, and reading in a file should create a new Bitmap instance.
* The CLI should require at least three arguments: input-file-path output-file-path transform-name.
* The CLI should support a minimum of three transforms, each of which is an instance method in the Bitmap class.
* The CLI should log useful Error messages if used incorrectly.
* The CLI should log a success message on completion.

## Testing
* Use JUnit to define descriptive tests.
* Each @Test method should aim to test a small well defined feature of a function.
* Write tests to ensure each function behaves correctly with valid and invalid inputs.

