import tkinter as tk
from tkinter import messagebox

class QuizApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Quiz App")
        self.current_question = 0
        self.score = 0

        self.questions = [
            {
                "question": "Who is the CEO of Google company?",
                "options": ["Sundar Pichai", "Larry Page", "Sergey Brin", "Jorge Washington"],
                "correct_option": 0
            },
            {
                "question": "Which planet is known as the Red Planet?",
                "options": ["Mars", "Venus", "Jupiter", "Saturn"],
                "correct_option": 0
            },
            {
                "question": "What is the longest river in the world?",
                "options": ["Amazon", "Ganga", "Nile", "Pravara"],
                "correct_option": 2
            },
        ]

        self.label = tk.Label(root, text="", font=("Helvetica", 16))
        self.label.pack(pady=10)

        self.radio_var = tk.IntVar()
        self.radio_var.set(-1)

        self.option_buttons = []
        for i in range(4):
            button = tk.Radiobutton(root, text="", variable=self.radio_var, value=i)
            button.pack()
            self.option_buttons.append(button)

        self.next_button = tk.Button(root, text="Next", command=self.next_question)
        self.next_button.pack(pady=10)

        self.update_question()

    def update_question(self):
        if self.current_question < len(self.questions):
            question_data = self.questions[self.current_question]
            self.label.config(text=question_data["question"])

            for i in range(4):
                self.option_buttons[i].config(text=question_data["options"][i])

            self.radio_var.set(-1)
        else:
            self.show_result()

    def next_question(self):
        if self.radio_var.get() == -1:
            messagebox.showerror("Error", "Please select an option.")
        else:
            if self.radio_var.get() == self.questions[self.current_question]["correct_option"]:
                self.score += 1
            self.current_question += 1
            self.update_question()

    def show_result(self):
        messagebox.showinfo("Result", f"You scored {self.score} out of {len(self.questions)}")
        self.root.destroy()

if __name__ == "__main__":
    root = tk.Tk()
    app = QuizApp(root)
    root.mainloop()
