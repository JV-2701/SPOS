import tkinter as tk
from tkinter import messagebox

class QuizApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Desktop Quiz")
        self.root.geometry("400x400")

        self.questions = [
            {
                "question": "What is 2 + 2?",
                "correct_answer": "4",
                "options": ["3", "4", "5", "6"]
            },
            {
                "question": "Which planet is known as the Red Planet?",
                "correct_answer": "Mars",
                "options": ["Venus", "Mars", "Jupiter", "Saturn"]
            },
            {
                "question": "Who painted the Mona Lisa?",
                "correct_answer": "Leonardo da Vinci",
                "options": ["Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo"]
            }
        ]

        self.question_index = 0
        self.score = 0


        self.create_widgets()

    def create_widgets(self):
        frame = tk.Frame(self.root)
        frame.pack(expand=True, fill="both")

        title_label = tk.Label(frame, text="Welcome to the Quiz", font=("Helvetica", 16, "bold"))
        title_label.pack(pady=10)

        self.question_label = tk.Label(frame, text="", font=("Helvetica", 12))
        self.question_label.pack()

        self.answer_entry = tk.Entry(frame, font=("Helvetica", 12))
        self.answer_entry.pack()

        self.option_var = tk.IntVar()
        self.option_var.set(0)

        option1 = tk.Radiobutton(frame, text="", variable=self.option_var, value=0, font=("Helvetica", 12))
        option2 = tk.Radiobutton(frame, text="", variable=self.option_var, value=1, font=("Helvetica", 12))
        option3 = tk.Radiobutton(frame, text="", variable=self.option_var, value=2, font=("Helvetica", 12))
        self.option_buttons=[option1,option2,option3]
        option1.pack()
        option2.pack()
        option3.pack()

        self.info_var = tk.IntVar()
        info_checkbox = tk.Checkbutton(frame, text="Include additional information", variable=self.info_var, font=("Helvetica", 12))
        info_checkbox.pack()

        submit_button = tk.Button(frame, text="Submit", command=self.submit_answer, font=("Helvetica", 12))
        submit_button.pack(pady=10)

        self.display_question()

    def display_question(self):
        if self.question_index < len(self.questions):
            question_data = self.questions[self.question_index]
            self.question_label.config(text=f"Question {self.question_index + 1}: {question_data['question']}")
            options = question_data["options"]
            for i in range(3):
                self.option_var.set(i)
                self.option_buttons[i].config(text=options[i])
            self.question_index += 1
        else:
            self.show_score()

    def submit_answer(self):
        question_data = self.questions[self.question_index - 1]
        selected_option = question_data["options"][self.option_var.get()]
        if selected_option == question_data["correct_answer"]:
            self.score += 1
        if self.question_index < len(self.questions):
            self.display_question()
        else:
            self.show_score()

    def show_score(self):
        messagebox.showinfo("Quiz Completed", f"You scored {self.score} out of {len(self.questions)}")
        self.root.quit()


if __name__ == "__main__":
    root = tk.Tk()
    app = QuizApp(root)
    root.mainloop()

