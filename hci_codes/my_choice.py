import tkinter as tk
from tkinter import messagebox

def submit_survey():
    name = name_entry.get()
    gender = gender_var.get()
    age = age_var.get()
    feedback = feedback_text.get("1.0", "end-1c")
    hobbies = [hobby_var.get() for hobby_var in hobby_vars]

    # Process and display the survey data
    result = f"Name: {name}\nGender: {gender}\nAge: {age}\nFeedback: {feedback}\nHobbies: {', '.join(hobbies)}"

    messagebox.showinfo("Survey Submitted", result)

root = tk.Tk()
root.title("Survey Form")

# Name
name_label = tk.Label(root, text="Name:")
name_label.pack()
name_entry = tk.Entry(root)
name_entry.pack()

# Gender
gender_var = tk.StringVar()
gender_label = tk.Label(root, text="Gender:")
gender_label.pack()
male_radio = tk.Radiobutton(root, text="Male", variable=gender_var, value="Male")
female_radio = tk.Radiobutton(root, text="Female", variable=gender_var, value="Female")
male_radio.pack()
female_radio.pack()

# Age
age_label = tk.Label(root, text="Age:")
age_label.pack()
age_var = tk.StringVar()
age_spinbox = tk.Spinbox(root, from_=1, to=100, textvariable=age_var)
age_spinbox.pack()

# Feedback
feedback_label = tk.Label(root, text="Feedback:")
feedback_label.pack()
feedback_text = tk.Text(root, height=5, width=30)
feedback_text.pack()

# Hobbies
hobby_label = tk.Label(root, text="Hobbies:")
hobby_label.pack()
hobby_vars = [tk.IntVar() for _ in range(3)]
hobby_checkboxes = [tk.Checkbutton(root, text=hobby, variable=hobby_var) for hobby, hobby_var in zip(["Reading", "Gaming", "Traveling"], hobby_vars)]
for checkbox in hobby_checkboxes:
    checkbox.pack()

# Submit Button
submit_button = tk.Button(root, text="Submit", command=submit_survey)
submit_button.pack()

root.mainloop()
