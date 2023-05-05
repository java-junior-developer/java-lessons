package ru.itmo.lessons.lesson22.composite;

public class AppImage extends Drawable{
    private String path;
    public AppImage(String title, String path) {
        super(title);
        this.path = path;
    }

    @Override
    void draw() {
        System.out.println(title);
    }
}
