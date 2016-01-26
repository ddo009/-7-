import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class SutdaDeck {

    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        for (int i = 0; i < cards.length; i++) {
            if (i == 0 || i == 2 || i == 7) {
                cards[i] = new SutdaCard(i + 1, true);
            } else if (9 < i) {
                cards[i] = new SutdaCard(i - 9, false);
            } else {
                cards[i] = new SutdaCard(i + 1, false);
            }
            System.out.println(cards[i]);
        }
    }

    void shuffle() {
        ArrayList<SutdaCard> sutda = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            sutda.add(cards[i]);
        }
        Collections.shuffle(sutda); // 리스트내의 값을 랜덤하게 재배열
        for (int i = 0; i < cards.length; i++) {
            cards[i] = sutda.get(i);
        }

    }

    SutdaCard pick(int index) {
        return cards[index];
    }

    SutdaCard pick() {
        int ranCard = new Random().nextInt(20);
        return cards[ranCard];
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {

        this.num = num;
        this.isKwang = isKwang;

    }

    // info()대신 Object클래스의 toString()을 오버라이딩했다.
    @Override
    public String toString() {

        return num + (isKwang ? "K" : "");

    }

}

class Main {

    public static void main(String args[]) {

        SutdaDeck deck = new SutdaDeck();
        deck.shuffle();
        for (int i = 0; i < deck.cards.length; i++)
            System.out.print(deck.cards[i] + ",");
        System.out.println();
        System.out.println(deck.pick(0));
        System.out.println(deck.pick());

    }

}
