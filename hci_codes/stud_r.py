import tkinter as tk
from tkinter import messagebox

def submit_registration():
    first_name = first_name_entry.get()
    last_name = last_name_entry.get()
    gender = gender_var.get()
    selected_courses = [course_var.get() for course_var in course_vars]

    # Display registration information in a messagebox
    registration_info = f"First Name: {first_name}\nLast Name: {last_name}\nGender: {gender}\nCourses: {', '.join(selected_courses)}"
    messagebox.showinfo("Registration Information", registration_info)

# Create the main window
window = tk.Tk()
window.title("Student Registration Form")

# Create and configure the first name label and entry
first_name_label = tk.Label(window, text="First Name:")
first_name_label.pack()
first_name_entry = tk.Entry(window)
first_name_entry.pack()

# Create and configure the last name label and entry
last_name_label = tk.Label(window, text="Last Name:")
last_name_label.pack()
last_name_entry = tk.Entry(window)
last_name_entry.pack()

# Create and configure the gender label and radio buttons
gender_label = tk.Label(window, text="Gender:")
gender_label.pack()
gender_var = tk.StringVar()

male_radio = tk.Radiobutton(window, text="Male", variable=gender_var, value="Male")
female_radio = tk.Radiobutton(window, text="Female", variable=gender_var, value="Female")
male_radio.pack()
female_radio.pack()

# Create and configure the courses label and checkboxes
courses_label = tk.Label(window, text="Select Favorite Course:")
courses_label.pack()

courses = ["HCI", "TOC", "DBMS", "CNS","SPOS"]
course_vars = [tk.BooleanVar() for _ in courses]
for course, var in zip(courses, course_vars):
    course_checkbox = tk.Checkbutton(window, text=course, variable=var, onvalue=course)
    course_checkbox.pack()

# Create and configure the submit button
submit_button = tk.Button(window, text="Submit", command=submit_registration)
submit_button.pack()

# Run the main loop
window.mainloop()
