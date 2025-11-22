**Preface**
These first three chapters tell we a little bit about Python, its strengths and weaknesses, and why we should consider learning Python. In chapter 2, we see how to run Python using Google Colaboratory, how to access the book's example code repository on GitHub, and how to write a simple program. Chapter 3 is a quick, high-level survey of Python's syntax and features. If we're looking for the quickest possible introduction to Python, start with chapter 3.

### 2.1.3 Devices, platforms, and operating systems
We can run Python on a wide variety of devices and on many operating systems. While in the early days, a server or desktop computer was the norm, today Python runs on many processeros, from embedded devices and single board computers to phones and tablets, to Chromebooks, laptops, and desktops, to virtual machines and containers, to server clusters, and so on. While te most common implementation of Python is based on the C language, there are versions that are written in and run on Java, in the browser based on AWSM, or even in applications like Excel.

## 2.2 Colaboratory: Jupyter notebooks in the cloud
As mentioned at the beginning of this chapter, for this book I recommend using Jupyter
notebooks, specifically, the hosted version of Jupyter from Google, Colaboratory.
Using Colaboratory means that you don’t need to worry about installing (or updating)
Python, and you can take advantage of Jupyter’s friendly interface, which is becoming
increasingly popular, particularly for data science.

### 2.2.1 Getting the source notebooks
The simplest way to get started with Colaboratory and this book is by accessing a notebook
in the GitHub repository. If you are not familiar with GitHub, it’s a very popular
online version control service based on the version control tool Git. To access the
notebooks in the repository, you don’t need to know how to use Git, nor do you need
to have an account on GitHub—just following the links given here will get you started.
You can find the GitHub repository at https://github.com/nceder/qpb4e/tree/
main; the notebooks for each chapter are in separate directories inside the code directory.
To get started, let’s find and open the notebook for chapter 2 (this chapter). If you
look in the Chapter 02 directory, you will find a notebook file called Chapter_02.ipynb
(direct link at https://mng.bz/gaDG). You should see a page similar to the one shown
in figure 2.1.

### 2.2.2 Getting started with Colaboratory
If you click the Chapter_02.ipynb file, you can view its contents using GitHub’s viewer
(as shown in figure 2.2), and at the top of the code window (right above 2.2 Getting
Started with Python and Colaboratory), you should also see a blue button link Open
in Colab.

If you click that link, it will open that notebook in a Colaboratory session where you
can edit, run, and experiment with the code, as shown in figure 2.3.


## 2.3 Writing and running code in Colaboratory
A Jupyter notebook consists of two types of cells: text cells and code cells. The text cells are meant to contain text, which can be formatted using the Markdown text formating language 