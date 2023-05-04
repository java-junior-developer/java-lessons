package questions.questions06;

import java.util.Scanner;

public class Building implements CloseableItem {
    private final static int MAX_ROOMS_COUNT = 50;
    private final Color color;
    private Room[] rooms;
    private boolean isClosed;

    public Building(Color color, int numberOfRooms) {
        this.color = color;
        class RoomsCreator {
            private final static int MAX_ROOMS_COUNT = 20;
            private final static int MIN_ROOMS_COUNT = 9;

            public RoomsCreator() {
                int arrLen = Math.min(MAX_ROOMS_COUNT, Math.max(MIN_ROOMS_COUNT, numberOfRooms));
                rooms = new Room[arrLen];
            }

            public void createRooms() {
                for (int i = 0; i < rooms.length; i++) {
                    rooms[i] = new Room();
                }
            }
        }
        new RoomsCreator().createRooms();
    }

    public void open() {
        if (isClosed) {
            System.out.println("Вы не можете попасть в здание");
            return;
        }
        new FindSecretRooms().start();
        close();
    }

    public void close() {
        for (Room room : rooms) {
            room.close();
        }
        isClosed = true;
    }

    class FindSecretRooms {
        private int attempts = rooms.length / 3;
        private int sum;

        public void start() {
            Scanner scanner = new Scanner(System.in);
            while (attempts > 0) {
                System.out.println("Введите номер комнаты от 0 до " + (rooms.length - 1));
                int number = scanner.nextInt();
                if (number < 0 || number >= rooms.length) continue;
                if (rooms[number].withSecret) {
                    sum += 1;
                }
                attempts -= 1;
            }
            printInfo();
        }

        private void printInfo() {
            System.out.println("Найдено комнат с секретом " + sum);
        }
    }

    private static class Room implements CloseableItem {
        private boolean withSecret;
        private boolean isClosed;

        public Room() {
            this.withSecret = Math.random() < 0.5;
        }

        public void close() {
            isClosed = true;
        }

        public boolean isClosed() {
            return isClosed;
        }
    }

    enum Color {
        WHITE, ORANGE, BLUE
    }
}