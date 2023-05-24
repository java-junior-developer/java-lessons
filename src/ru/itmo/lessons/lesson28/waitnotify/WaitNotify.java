package ru.itmo.lessons.lesson28.waitnotify;

public class WaitNotify {
    public static void main(String[] args) {
        Library library = new Library();

        new PutThread(library).start();
        new GetThread(library).start();
        new PutThread(library).start();
        new GetThread(library).start();
    }

    static class GetThread extends Thread{
        private final Library library;

        public GetThread(Library library) {
            this.library = library;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    library.getBook();
                    Thread.sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class PutThread extends Thread{
        private final Library library;

        public PutThread(Library library) {
            this.library = library;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                    library.addBook(new Library.Book());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
