// ask how many chips to start with, ask how many to bet this round,
// shuffle and deal, print cards that player has, type hit or stand,
// computer goes, says hit or stand if 16 or less or if 17 or greater, switch back to player

import java.util.*;

public class Poker {
    private final String[] SUITS = {"C", "D", "H", "S"};
    private final String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
    private char whoseTurn;
    private int counter = 0;
    private final Player player;
    private final Player computer;
    private List<Card> deck;
    private final Scanner in;
    private boolean playerStand;
    private static double chips;
    private static double wager;

    public Poker() {
        this.whoseTurn = 'P';
        this.player = new Player();
        this.computer = new Player();
        this.in = new Scanner(System.in);
    }

    public void play() {

        String answer = "";

        System.out.println("\nPLAYER chips: " + (int) chips);
        System.out.println("PLAYER wager: " + (int) wager);

        shuffleAndDeal();

        while (true) {
            while (counter < 3) {
                whoseTurn = takeTurn(false);
            }

            if (playerStand) {
                boolean result = player.checkRoyalFlush();
                if (result) {
                    showHand(false);
                    System.out.println("\nROYAL FLUSH, PLAYER win!");
                    chips += (wager * 100);
                    System.out.println("PLAYER chips: " + (int) chips);
                    System.out.println("Keep going? (Y/N)");
                    answer = in.next();
                    if (answer.equals("Y") || answer.equals("y")) {
                        do {
                            System.out.print("\nHow many chips will you wager this round? ");
                            wager = in.nextInt();

                            if (wager < 1 || wager > 25) {
                                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
                            } else if (chips < wager) {
                                System.out.print("\nInsufficient funds.");
                            }
                        } while (wager < 1 || wager > 25);
                        new Poker().play();
                    } else if (answer.equals("N") || answer.equals("n")) {
                        System.out.println("\nSee ya next time!");
                        break;
                    }
                }

                boolean result2 = player.checkStraightFlush();
                if (result2) {
                    showHand(false);
                    System.out.println("\nSTRAIGHT FLUSH, PLAYER win!");
                    chips += (wager * 50);
                    System.out.println("PLAYER chips: " + (int) chips);
                    System.out.println("Keep going? (Y/N)");
                    answer = in.next();
                    if (answer.equals("Y") || answer.equals("y")) {
                        do {
                            System.out.print("\nHow many chips will you wager this round? ");
                            wager = in.nextInt();

                            if (wager < 1 || wager > 25) {
                                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
                            } else if (chips < wager) {
                                System.out.print("\nInsufficient funds.");
                            }
                        } while (wager < 1 || wager > 25);
                        new Poker().play();
                    } else if (answer.equals("N") || answer.equals("n")) {
                        System.out.println("\nSee ya next time!");
                        break;
                    }
                }

                boolean result3 = player.checkFourOfAKind();
                if (result3) {
                    showHand(false);
                    System.out.println("\nFOUR OF A KIND, PLAYER win!");
                    chips += (wager * 25);
                    System.out.println("PLAYER chips: " + (int) chips);
                    System.out.println("Keep going? (Y/N)");
                    answer = in.next();
                    if (answer.equals("Y") || answer.equals("y")) {
                        do {
                            System.out.print("\nHow many chips will you wager this round? ");
                            wager = in.nextInt();

                            if (wager < 1 || wager > 25) {
                                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
                            } else if (chips < wager) {
                                System.out.print("\nInsufficient funds.");
                            }
                        } while (wager < 1 || wager > 25);
                        new Poker().play();
                    } else if (answer.equals("N") || answer.equals("n")) {
                        System.out.println("\nSee ya next time!");
                        break;
                    }
                }

                boolean result4 = player.checkFullHouse();
                if (result4) {
                    showHand(false);
                    System.out.println("\nFULL HOUSE, PLAYER win!");
                    chips += (wager * 15);
                    System.out.println("PLAYER chips: " + (int) chips);
                    System.out.println("Keep going? (Y/N)");
                    answer = in.next();
                    if (answer.equals("Y") || answer.equals("y")) {
                        do {
                            System.out.print("\nHow many chips will you wager this round? ");
                            wager = in.nextInt();

                            if (wager < 1 || wager > 25) {
                                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
                            } else if (chips < wager) {
                                System.out.print("\nInsufficient funds.");
                            }
                        } while (wager < 1 || wager > 25);
                        new Poker().play();
                    } else if (answer.equals("N") || answer.equals("n")) {
                        System.out.println("\nSee ya next time!");
                        break;
                    }
                }

                boolean result5 = player.checkFlush();
                if (result5) {
                    showHand(false);
                    System.out.println("\nFLUSH, PLAYER win!");
                    chips += (wager * 10);
                    System.out.println("PLAYER chips: " + (int) chips);
                    System.out.println("Keep going? (Y/N)");
                    answer = in.next();
                    if (answer.equals("Y") || answer.equals("y")) {
                        do {
                            System.out.print("\nHow many chips will you wager this round? ");
                            wager = in.nextInt();

                            if (wager < 1 || wager > 25) {
                                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
                            } else if (chips < wager) {
                                System.out.print("\nInsufficient funds.");
                            }
                        } while (wager < 1 || wager > 25);
                        new Poker().play();
                    } else if (answer.equals("N") || answer.equals("n")) {
                        System.out.println("\nSee ya next time!");
                        break;
                    }
                }

                boolean result6 = player.checkStraight();
                if (result6) {
                    showHand(false);
                    System.out.println("\nSTRAIGHT, PLAYER win!");
                    chips += (wager * 5);
                    System.out.println("PLAYER chips: " + (int) chips);
                    System.out.println("Keep going? (Y/N)");
                    answer = in.next();
                    if (answer.equals("Y") || answer.equals("y")) {
                        do {
                            System.out.print("\nHow many chips will you wager this round? ");
                            wager = in.nextInt();

                            if (wager < 1 || wager > 25) {
                                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
                            } else if (chips < wager) {
                                System.out.print("\nInsufficient funds.");
                            }
                        } while (wager < 1 || wager > 25);
                        new Poker().play();
                    } else if (answer.equals("N") || answer.equals("n")) {
                        System.out.println("\nSee ya next time!");
                        break;
                    }
                }

                boolean result7 = player.checkThreeOfAKind();
                if (result7) {
                    showHand(false);
                    System.out.println("\nTHREE OF A KIND, PLAYER win!");
                    chips += (wager * 3);
                    System.out.println("PLAYER chips: " + (int) chips);
                    System.out.println("Keep going? (Y/N)");
                    answer = in.next();
                    if (answer.equals("Y") || answer.equals("y")) {
                        do {
                            System.out.print("\nHow many chips will you wager this round? ");
                            wager = in.nextInt();

                            if (wager < 1 || wager > 25) {
                                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
                            } else if (chips < wager) {
                                System.out.print("\nInsufficient funds.");
                            }
                        } while (wager < 1 || wager > 25);
                        new Poker().play();
                    } else if (answer.equals("N") || answer.equals("n")) {
                        System.out.println("\nSee ya next time!");
                        break;
                    }
                }

                boolean result8 = player.checkTwoPair();
                if (result8) {
                    showHand(false);
                    System.out.println("\nTWO PAIR, PLAYER win!");
                    chips += (wager * 2);
                    System.out.println("PLAYER chips: " + (int) chips);
                    System.out.println("Keep going? (Y/N)");
                    answer = in.next();
                    if (answer.equals("Y") || answer.equals("y")) {
                        do {
                            System.out.print("\nHow many chips will you wager this round? ");
                            wager = in.nextInt();

                            if (wager < 1 || wager > 25) {
                                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
                            } else if (chips < wager) {
                                System.out.print("\nInsufficient funds.");
                            }
                        } while (wager < 1 || wager > 25);
                        new Poker().play();
                    } else if (answer.equals("N") || answer.equals("n")) {
                        System.out.println("\nSee ya next time!");
                        break;
                    }
                }

                boolean result9 = player.checkGoodPair();
                if (result9) {
                    showHand(false);
                    System.out.println("\nHIGH PAIR, PLAYER win!");
                    chips += wager;
                    System.out.println("PLAYER chips: " + (int) chips);
                    System.out.println("Keep going? (Y/N)");
                    answer = in.next();
                    if (answer.equals("Y") || answer.equals("y")) {
                        do {
                            System.out.print("\nHow many chips will you wager this round? ");
                            wager = in.nextInt();

                            if (wager < 1 || wager > 25) {
                                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
                            } else if (chips < wager) {
                                System.out.print("\nInsufficient funds.");
                            }
                        } while (wager < 1 || wager > 25);
                        new Poker().play();
                    } else if (answer.equals("N") || answer.equals("n")) {
                        System.out.println("\nSee ya next time!");
                        break;
                    }
                }

                boolean result0 = player.nothing();
                if (result0) {
                    showHand(false);
                    System.out.println("\nBetter luck next time!");
                    chips -= wager;
                    System.out.println("PLAYER chips: " + (int) chips);
                    System.out.println("Keep going? (Y/N)");
                    answer = in.next();
                    if (answer.equals("Y") || answer.equals("y")) {
                        do {
                            System.out.print("\nHow many chips will you wager this round? ");
                            wager = in.nextInt();

                            if (wager < 1 || wager > 25) {
                                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
                            } else if (chips < wager) {
                                System.out.print("\nInsufficient funds.");
                            }
                        } while (wager < 1 || wager > 25);
                        new Poker().play();
                    } else if (answer.equals("N") || answer.equals("n")) {
                        System.out.println("\nSee ya next time!");
                        break;
                    }
                }
            }
        }
    }

    public void shuffleAndDeal() {
        if (deck == null) {
            initializeDeck();
        }
        Collections.shuffle(deck);
        while (player.getHand().size() < 5) {
            player.takeCard(deck.remove(0));
        }
    }

    private void initializeDeck() {
        deck = new ArrayList<>(52);

        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    private char takeTurn(boolean cpu) {
        if (!cpu) {
            showHand(false);
        }

        requestCard(cpu);


        return 'x';
    }

    private Card requestCard(boolean cpu) {
        Card card = null;

        while (true) {
            if (!cpu) {
                System.out.print("PLAYER: Will you trade a card? ");
                String answer = in.nextLine().trim().toUpperCase();

                if (answer.equals("YES")) {
                    counter++;

                    System.out.print("PLAYER: Which card will you trade? ");
                    String answer1 = in.nextLine().trim().toUpperCase();

                    switch (answer1) {
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                        case "T":
                        case "J":
                        case "Q":
                        case "K":
                        case "A":
                            player.removeRequestedCard(answer1);
                            player.takeCard(deck.remove(0));
                            break;
                    }

                    if (counter == 3) {
                        playerStand = true;
                        return null;
                    }
                } else if (answer.equals("NO")) {
                    counter = 3;
                    playerStand = true;
                    return null;
                }

                return null;
            }
        }
    }


    private void showHand(boolean cpu) {
        if (!cpu) {
            System.out.println("\nPLAYER hand: " + player.getHand());
        } else {
            System.out.println("CPU hand: " + computer.getHand());
        }
    }


    public static void main(String[] args) {
        System.out.println("################################################");
        System.out.println("#                                              #");
        System.out.println("#   ####### #######  #    ## ####### #######   #");
        System.out.println("#   #     # #     #  #   #   #       #     #   #");
        System.out.println("#   ######  #     #  ####    ####    #####     #");
        System.out.println("#   #       #     #  #   #   #       #   #     #");
        System.out.println("#   #       #######  #    ## ####### #     #   #");
        System.out.println("#                                              #");
        System.out.println("#   A Java recreation of the 5-card stud Poker #");
        System.out.println("#                                              #");
        System.out.println("################################################");

        Scanner in = new Scanner(System.in);
        System.out.print("\nHow many chips will you buy in for? ");
        chips = in.nextInt();

        do {
            System.out.print("\nHow many chips will you wager this round? ");
            wager = in.nextInt();

            if (wager < 1 || wager > 25) {
                System.out.print("\nPlease wager at least 1 chip and at most 25 chips.");
            } else if (chips < wager) {
                System.out.print("\nInsufficient funds.");
            }
        } while (wager < 1 || wager > 25);


        new Poker().play();
    }
}