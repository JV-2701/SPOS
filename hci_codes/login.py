import tkinter as tk
from tkinter import messagebox

def validate_login():
    username = username_entry.get()
    password = password_entry.get()
    
    # Add your login validation logic here
    # For this example, we'll use a simple hardcoded username and password
    if username == "anushka197" and password == "anu@123":
        messagebox.showinfo("Login Successful", "Welcome, " + username + "!")
    else:
        messagebox.showerror("Login Failed", "Invalid username or password")

# Create the main window
window = tk.Tk()
window.title("Login Window")

# Create and configure the username label and entry
username_label = tk.Label(window, text="Username")
username_label.pack()
username_entry = tk.Entry(window)
username_entry.pack()

# Create and configure the password label and entry
password_label = tk.Label(window, text="Password")
password_label.pack()
password_entry = tk.Entry(window, show="*")  # Show asterisks for password input
password_entry.pack()

# Create and configure the login button
login_button = tk.Button(window, text="Login", command=validate_login)
login_button.pack()

# Run the main loop
window.mainloop()
