import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnatChatRoom {

	private String roomName;
	private List<SnatChatFrontend> frontends = new LinkedList<>();

	SnatChatRoom(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void register(SnatChatFrontend s) {
		this.frontends.add(s);

		try (BufferedReader reader = new BufferedReader(new FileReader(this.roomName + ".txt"))) {
			List<String> lines = new ArrayList<>();
			while (reader.ready()) {
				
				lines.add(Message.rot13(reader.readLine()));
			}
			if (lines.size() > 10) {
				lines = lines.subList(lines.size() - 10, lines.size());
			}
			
			int startIndex = Math.max(0, lines.size()-10);
			for(int i = startIndex; i<= lines.size(); i++) {
				s.receiveMessage(lines.get(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void unregister(SnatChatFrontend s) {
		this.frontends.remove(s);
	}

	public void sendMessage(Message msg) {
		for (SnatChatFrontend f : this.frontends) {
			f.receiveMessage(msg);
		}
		logToFile(msg.getTransmitter() + msg.getText());
	}

	public void sendMessage(String text) {
		for (SnatChatFrontend f : this.frontends) {
			f.receiveMessage(text);
		}
		logToFile(text);
	}

	public void logToFile(String line) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.roomName + ".txt", true));
			pw.println(Message.rot13(line));
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("aa");
		}
	}
}
