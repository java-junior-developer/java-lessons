package ru.itmo.lessons.lesson22.composite;

public class Render {
    private Drawable drawable;

    public Render(Drawable drawable) {
        this.drawable = drawable;
    }
    public void show(){
        drawable.draw();
    }
}
