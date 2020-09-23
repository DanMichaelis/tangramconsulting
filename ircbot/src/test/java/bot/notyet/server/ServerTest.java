package bot.notyet.server;

import static org.junit.Assert.*;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import bot.notyet.config.BotServerDefaults;

public class ServerTest {

	@Test
	public void testServerList() {
		ObjectMapper mapper = new ObjectMapper();
		List<Server> servers = null;

		try {
			String val = new String(
					(new BufferedInputStream(mapper.getClass().getClassLoader().getResourceAsStream("servers.json")))
							.readAllBytes());
			servers = mapper.readValue(val, new TypeReference<List<Server>>() {
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (null != servers) {
			for (Server server : servers) {
				System.out.println("Server: " + server.getServerName());
			}
		}
	}

	@Test
	public void testBotServerDefault() {
		ObjectMapper mapper = new ObjectMapper();
		List<BotServerDefaults> botDefaults = null;
		try {
			String val = new String(
					(new BufferedInputStream(mapper.getClass().getClassLoader().getResourceAsStream("botServerDefaults.json")))
							.readAllBytes());
			botDefaults = mapper.readValue(val, new TypeReference<List<BotServerDefaults>> () {});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (BotServerDefaults bsd : botDefaults) {
			System.out.println(bsd.toString());
		}
	}
	
	@Test
	public void testMapMarshalling() {
		HashMap foo = new HashMap<String, ArrayList<Server>>();
		ArrayList<Server> servers = new ArrayList<Server>();
		servers.add(new Server("server1", "www.server1.com", 1234,false));
		servers.add(new Server("server2", "www.server2.com", 1234,false));
		servers.add(new Server("server3", "www.server3.com", 1234,false));
		foo.put("Bot1", servers);
		servers = new ArrayList<Server>();
		servers.add(new Server("server4", "www.server1.com", 1234,false));
		servers.add(new Server("server5", "www.server2.com", 1234,false));
		servers.add(new Server("server6", "www.server3.com", 1234,false));
		foo.put("Bot2", servers);
		
		ObjectMapper mapper = new ObjectMapper();
		Path outputFile = Paths.get("/tmp/object.json");
		try {
		Files.createDirectories(outputFile.getParent());
		Files.createFile(outputFile);
		OutputStream out = Files.newOutputStream(outputFile);
		mapper.writeValue(out, foo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
