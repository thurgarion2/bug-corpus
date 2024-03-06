package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// imagine a far more complex example
public class MessageQueueExample {

    public static void main(String[] args) {
        Random rand = new Random(1);
        MessageQueue messageQueue = new MessageQueue(new Socket());
        Client client = new Client(messageQueue);

        for(int i=0; i<100; ++i){
            switch (rand.nextInt(Math.min(i/5+1, 5))){
                case 0:
                    client.authentify("password");
                    break;
                case 1:
                    client.sendForm("aForm");
                    break;
                case 2:
                    client.sendName("name");
                    break;
                case 3:
                    messageQueue.executeMessage();
                    break;
                case 4:
                    client.executionContextDestroyed();
                    break;
            }
        }
    }

    static class Client {
        MessageQueue messages;

        public Client(MessageQueue messages){
            this.messages = messages;
        }

        public void sendName(String name){
            messages.add(new Message("a message"));
        }

        public void sendForm(String form){
            messages.add(new Message("a message"));
        }

        public void authentify(String password){
            messages.add(new Message("a message"));
        }

        public void executionContextDestroyed(){
            messages.add(new Message("a message"));
            deallocateSocket();
        }

        private void deallocateSocket(){
            messages.socket = null;
        }


    }

    static class Message {
        final String payload;
        public Message(String payload){
            this.payload = payload;
        }
    }

    static class MessageQueue {
        Socket socket;
        List<Message> messages;

        public MessageQueue(Socket socket){
            this.socket = socket;
            messages = new ArrayList<>();
        }

        public void add(Message m){
            messages.add(m);
        }

        public void executeMessage(){
            if(messages.size()>5){
                while(!messages.isEmpty()){
                    socket.send(messages.remove(0));
                }
            }
        }
    }

    static class Socket {
        public void send(Message m){

        }
    }
}
