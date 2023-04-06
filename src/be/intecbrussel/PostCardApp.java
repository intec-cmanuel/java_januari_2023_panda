package be.intecbrussel;

import java.util.*;

public class PostCardApp {
    public static void main(String[] args) {

        //your cards
        PostCard belgium = new PostCard("Belgium", "Europe");
        PostCard france = new PostCard("France", "Europe");
        PostCard japan = new PostCard("Japan", "Asia");
        PostCard rdc = new PostCard("Democratic Republic of Congo", "Africa");
        PostCard southKorea = new PostCard("South Korea", "Asia");
        PostCard belgium2 = new PostCard("Belgium", "Europe");
        PostCard southAfrica = new PostCard("South Africa", "Africa");
        PostCard france2 = new PostCard("France", "Europe");
        PostCard belgium3 = new PostCard("Belgium", "Europe");
        PostCard usa = new PostCard("United States of America", "North America");
        PostCard canada = new PostCard("Canada", "North America");
        PostCard peru = new PostCard("Peru", "South America");
        PostCard samoa = new PostCard("Samoa", "Oceania");
        PostCard belgium4 = new PostCard("Belgium", "Europe");
        PostCard france3 = new PostCard("France", "Europe");


        List<PostCard> yourPostCardList = new ArrayList<>();
        yourPostCardList.add(belgium);
        yourPostCardList.add(france);
        yourPostCardList.add(japan);
        yourPostCardList.add(rdc);
        yourPostCardList.add(southKorea);
        yourPostCardList.add(belgium2);
        yourPostCardList.add(southAfrica);
        yourPostCardList.add(france2);
        yourPostCardList.add(belgium3);
        yourPostCardList.add(usa);
        yourPostCardList.add(canada);
        yourPostCardList.add(peru);
        yourPostCardList.add(samoa);
        yourPostCardList.add(belgium4);
        yourPostCardList.add(france3);


        //your friend’s cards
        PostCard northKorea = new PostCard("North Korea", "Asia");
        PostCard usa2 = new PostCard("United States of America", "North America");
        PostCard botswana = new PostCard("Botswana", "Africa");
        PostCard northKorea2 = new PostCard("North Korea", "Asia");


        List<PostCard> yourFriendsPostCardList = new ArrayList<>();
        yourFriendsPostCardList.add(northKorea);
        yourFriendsPostCardList.add(usa2);
        yourFriendsPostCardList.add(botswana);
        yourFriendsPostCardList.add(northKorea2);


        //your friends
        Friend bobby = new Friend("Bobby",false, 3, 5);
        Friend melissa = new Friend("Melissa",false, 1, 6);
        Friend darla = new Friend("Darla",true, 14, 2);
        Friend bert = new Friend("Bert",false, 10, 4);
        Friend grandma = new Friend("Nana",true, 12, 7);
        Friend fester = new Friend("Fester",false, 1, 2);
        Friend anna = new Friend("Anna",false, 8, 4);



        // oefening 1
        PostCard myPostCardToTrade = cardToTrade(yourPostCardList, yourFriendsPostCardList);
        int indexOfTradedCard = yourPostCardList.indexOf(myPostCardToTrade);

        PostCard friendPostCardToTrade = cardToTrade(yourFriendsPostCardList, yourPostCardList);
        int indexOfFriendCard = yourFriendsPostCardList.indexOf(friendPostCardToTrade);

        yourPostCardList.set(indexOfTradedCard, friendPostCardToTrade);
        yourFriendsPostCardList.set(indexOfFriendCard, myPostCardToTrade);

        // oefening 2
        yourPostCardList.sort(Comparator.comparing(PostCard::getCountry));

        // oefening 3
        Set<PostCard> myUniquePostCards = new TreeSet<>(Comparator.comparing(PostCard::getCountry));
        myUniquePostCards.addAll(yourPostCardList);

        List<PostCard> duplicates = new ArrayList<>(yourPostCardList);
        for (PostCard myUniquePostCard : myUniquePostCards) {
            duplicates.remove(myUniquePostCard);
        }

        yourPostCardList = new ArrayList<>(myUniquePostCards);

        System.out.println(yourPostCardList);
        System.out.println(yourFriendsPostCardList);
        System.out.println(duplicates);

        // oefening 4

//        Queue<Friend> sortedFriends = new PriorityQueue<>(
//                Comparator.comparing(Friend::isFamily)
//                        .thenComparing(Friend::getFriendShipLevel)
//                        .thenComparing(Friend::getYearsKnown)
//        );

        Queue<Friend> sortedFriends = new PriorityQueue<>(
                Comparator.comparing(Friend::isFamily)
                        .thenComparing(Friend::getFriendShipLevel)
                        .thenComparing(Friend::getYearsKnown).reversed()
        );

        sortedFriends.offer(bobby);
        sortedFriends.offer(melissa);
        sortedFriends.offer(darla);
        sortedFriends.offer(bert);
        sortedFriends.offer(grandma);
        sortedFriends.offer(fester);
        sortedFriends.offer(anna);

        while(!sortedFriends.isEmpty()) {
            Friend f = sortedFriends.poll();
            System.out.println(f);
        }

        System.out.println("-".repeat(50));
    }

    private static PostCard cardToTrade(List<PostCard> listToTradeFrom, List<PostCard> listToTradeTo) {
        for (PostCard postCard : listToTradeFrom) {
            if (Collections.frequency(listToTradeFrom, postCard) <= 1) {
                continue;
            }

            if (listToTradeTo.contains(postCard)) {
                continue;
            }

            PostCard myPostCardToTrade = postCard;
            int indexOfTradedCard = listToTradeFrom.indexOf(postCard);

            return postCard;
        }
        return null;
    }
}
