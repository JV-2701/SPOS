import tkinter as tk
from tkinter import messagebox

def submit_feedback():
    name = name_entry.get()
    email = email_entry.get()
    feedback = feedback_text.get("1.0", "end-1c")
    food_quality = food_quality_var.get()
    service_quality = service_quality_var.get()
    cleanliness = cleanliness_var.get()

    feedback_message = f"Name: {name}\nEmail: {email}\nFeedback: {feedback}\nFood Quality: {food_quality}\nService Quality: {service_quality}\nCleanliness: {cleanliness}"

    # You can process and store the feedback data here, e.g., in a database.

    messagebox.showinfo("Feedback Submitted", "Thank you for your feedback!")
    clear_form()

def clear_form():
    name_entry.delete(0, "end")
    email_entry.delete(0, "end")
    feedback_text.delete("1.0", "end")
    food_quality_var.set(0)
    service_quality_var.set(0)
    cleanliness_var.set(0)

# Create the main window
window = tk.Tk()
window.title("Customer Feedback Form")

# Create and configure the Name label and entry
name_label = tk.Label(window, text="Name:")
name_label.pack()
name_entry = tk.Entry(window)
name_entry.pack()

# Create and configure the Email label and entry
email_label = tk.Label(window, text="Email:")
email_label.pack()
email_entry = tk.Entry(window)
email_entry.pack()

# Create and configure the Feedback label and text area
feedback_label = tk.Label(window, text="Feedback:")
feedback_label.pack()
feedback_text = tk.Text(window, height=5, width=30)
feedback_text.pack()

# Create and configure the Quality label and checkbuttons
quality_label = tk.Label(window, text="Quality:")

food_quality_var = tk.IntVar()
food_quality_check = tk.Checkbutton(window, text="Food Quality", variable=food_quality_var, onvalue=1, offvalue=0)
service_quality_var = tk.IntVar()
service_quality_check = tk.Checkbutton(window, text="Service Quality", variable=service_quality_var, onvalue=1, offvalue=0)
cleanliness_var = tk.IntVar()
cleanliness_check = tk.Checkbutton(window, text="Cleanliness", variable=cleanliness_var, onvalue=1, offvalue=0)

quality_label.pack()
food_quality_check.pack()
service_quality_check.pack()
cleanliness_check.pack()

# Create and configure the Submit and Clear buttons
submit_button = tk.Button(window, text="Submit", command=submit_feedback)
clear_button = tk.Button(window, text="Clear", command=clear_form)

submit_button.pack()
clear_button.pack()

# Run the main loop
window.mainloop()
