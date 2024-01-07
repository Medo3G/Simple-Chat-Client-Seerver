# Simple-Chat-Client-Server
 A simple single server chat client

## Usage
- Run the “Server” class.  
 ![](imgs/img1.png)
- Run the “Client” class.  
 ![](imgs/img2.png)
- Enter the IP address of the device running the server.(The client exits if it receives a wrong IP address).  
 ![](imgs/img3.png)
- You now have to enter a username. You can choose any username that you like as long it is not “REFRESH” or if it is already in use.  
 ![](imgs/img4.png)
- The client will keep asking the user for a username until they enter a proper one. When they do, they will receive a message informing them that they have successfully connected to the server using the specified username.  
![](imgs/img5.png)
- In this state you are able to :
  - Receive messages from other users on the server.  
  ![](imgs/img6.png)
  - Type “REFRESH” (all uppercase) to get an updated userlist.  
  ![](imgs/img7.png)
  - Choose a user to send messages to.  
  ![](imgs/img8.png)
- After choosing a user to chat with you can:
  - Type “BACK” (all uppercase) to return to the userlist and choose a different user to chat with.  
  ![](imgs/img9.png)
  - Receive messages from all users.  
  ![](imgs/img10.png)
  - Type a message to the chosen user.  
  ![](imgs/img11.png)
  - If you have chosen a user that doesn’t exist, or the user left during the conversation, and you try to send a message, you receive a message from the server informing you that the user doesn’t exist, and that you should return back to the userlist.  
  ![](imgs/img12.png)
- You can type “BYE”/”QUIT” (all uppercase) to disconnect from the server and close the
client.
  - During joining.  
  ![](imgs/img13.png)
  - In the userlist.  
  ![](imgs/img14.png)
  - While chatting with a user.  
  ![](imgs/img15.png)
- Meanwhile, the server logs when
  - A user connects.
  - A user chooses a username.
  - A user disconnects.  
  
![](imgs/img16.png)
***
Done as a part of Introduction to Communication Networks course.
