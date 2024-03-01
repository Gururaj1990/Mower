Scenario: when  provided file exists,it should read all lines of file
Given a File Path
And the file has some data
When we read content of a file
Then all the content should be returned

Scenario: when  provided file doesn't exists,throw error
Given a File Path which does't exists
When we read content of a file which does't exists
Then throw error