import java.util.*;

public class Main {
    private static ArrayList <Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        

        Album album = new Album("Album1", "Brockhampton");

        album.addSong("GOLD",4.5);
        album.addSong("Sugar",4.0);
        album.addSong("Rental",3.5);
        albums.add(album);

        album = new Album("Album2", "Koffee");

        album.addSong("Lockdown",4.2);
        album.addSong("Pressure",2.3);
        album.addSong("Toast",3.0);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("GOLD",playList_1);
        albums.get(0).addToPlayList("Rental",playList_1);
        albums.get(0).addToPlayList("Sugar",playList_1);
        albums.get(1).addToPlayList("Toast",playList_1);

        play(playList_1);

    }
    private static void play(LinkedList<Song> playList){
       Scanner sc = new Scanner(System.in);
       boolean quit = false;
       boolean forward = true;
       ListIterator<Song> listIterator = playList.listIterator();

       if(playList.size() == 0){
           System.out.println("This playlist has no songs");
       }else{
           System.out.println("Now playing" + listIterator.next().toString());
           printMenu();

           while(!quit){
               int action = sc.nextInt();

               switch(action){
                   case 0:
                       System.out.println("Playlist complete");
                       quit = true;
                    break;
                   case 1:
                       if(!forward){
                           if(listIterator.hasNext()){
                               listIterator.next();
                           }
                           forward = true;
                       }
                       if(listIterator.hasNext()){
                           System.out.println("Now playing" + listIterator.next().toString());
                       }else {
                           System.out.println("No song available, you've reached the end of the list");

                       }
                       break;
                   case 2:
                       if(forward){
                           if(listIterator.hasPrevious()){
                               listIterator.previous();
                               forward = false;
                           }
                       }else {
                           System.out.println("This is the first song");
                           forward=false;
                       }
                       break;
                   case 3:
                       if(forward){
                          if( listIterator.hasPrevious()){
                              System.out.println("Playing:" +listIterator.previous().toString());
                              forward = false;
                          }else{
                              System.out.println("We are at the start of the list");
                          }
                       }else{
                           if(listIterator.hasNext()){
                               System.out.println("Now playing"+listIterator.next().toString());
                               forward = true;
                           }else{
                               System.out.println("We have reached the end of the list");
                           }
                       }
                   case 4:
                       printList(playList);
                       break;
                   case 5:
                       printMenu();
                       break;
                   case 6:
                       if (playList.size()>0){
                           listIterator.remove();
                           if(listIterator.hasNext()){
                               System.out.println("now playing:"+listIterator.next().toString());

                           }
                       }else{
                           if(listIterator.hasPrevious())
                               System.out.println("now playing: "+listIterator.previous().toString());
                       }
                    break;
               }
           }
       }
    }

    private static void printMenu() {
        System.out.println("Available options \n press");
        System.out.println("""
                Press 0 to quit
                Press 1 to play the next song
                Press 2 to play the previous song
                Press 3 to replay the current song
                Press 5 to print all available options
                Press 6 to delete the current song
                """);
    }
        private static void printList(LinkedList<Song> playList){
            Iterator<Song> iterator = playList.iterator();
            System.out.println("---------------------");

            while (iterator.hasNext()){
                System.out.println(iterator.next());;
            }
            System.out.println("---------------------");
        }
    }

