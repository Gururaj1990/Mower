Scenario: when mower objet is provided instruction G,it should rotate left
Given a mower object with current direction East
And lawn dimensions are set
When left rotate operation is performed
Then mower direction should be changed to north

Scenario: when mower objet is provided instruction D,it should rotate right
Given a mower object with current direction East
And lawn dimensions are set
When right rotate operation is performed
Then mower direction should be changed to south

Scenario: when mower objet is provided instruction A,it should move forward in the current direction
Given a mower object with current direction East
And lawn dimensions are set
When move forward operation is performed
Then mower should move one step forward in east direction

Scenario: when mower objet is provided instruction A, and movement is exceeding lawn boundary retain original position
Given a mower object with current direction East and position right most corner
And lawn dimensions are set
When move forward operation is performed
Then mower should move retain its original postion