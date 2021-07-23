![Untitled presentation (2)](https://user-images.githubusercontent.com/85959093/126795592-7228babe-62fb-4287-b638-74c14f3a246f.png)
# Login & Registration
In this project, I created a login and registration using Google Firebase. First, I created an app on Android studio using Kotlin with 3 activities: MainActivity, LoginActivity, and RegisterActivity. Then I backed up the app by Google Firebase to store and authenticate users. 

# Tools 
Kotlin - Android Studio 

Google Firebase
Canva - for logo & design

# Topics

Mobile development 

Cloud authentication


# Planning 

This app initially started out as an E-commerce app project. After creating the memory game app, I wanted to created a more ambitious project and soon realized how many pieces of the puzzles there actually were: from registration and authentication to creating an online store to creating a safe check out experience. 


For this project I wanted to focus on the first piece of the puzzle: Registration and User Management. 


The first problem I ran into was deciding on where new users would be stored and how they would be authenticated to use the app. After some research, I decided I wanted to use a third party cloud platform to handle user management and authentication and after researching the different options, I decided to use Google Firebase as a container to store users for its simplicity and low costs. (Also because I'm learning GCP and wanted to learn more about Firebase.) 

# Execution

After designing the screens, I started coding the XML files for my project and began the coding process for my app. Here are the XML views for each screen.

Before coding each activity, I first had to create a project in Google Firebase to setup my app's container. There were a few configuration steps I had to follow to add firebase to my app in android studio like adding firebase dependencies to build.gradle files and adding a SHA certification to my project. Here is screenshot of what my project looks like in Google Firebase.

I used FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password) .addOnCompleteListener() and FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password) .addOnCompleteListener in the Register and Login activities respectively to create new users and authenticate existing users.

I coded the MainActivity.kt to show the user's credential (name, email) and a button to show the unique UID created for each user by Google Firebase. I also created a logout button to signout from the account and go back to the login screen. 

# Unique Firebase UID
![Untitled presentation (3)](https://user-images.githubusercontent.com/85959093/126796087-1337f0d9-b7f3-45a3-8c46-a8c94b9e1e7d.png)





