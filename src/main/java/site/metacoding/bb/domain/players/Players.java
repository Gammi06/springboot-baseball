package site.metacoding.bb.domain.players;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Players {
	private Integer id;
	private String teamname;
	private String position;
	private String playername;
	private Timestamp createdAt;

	public Players(String teamname, String position, String playername) {
		this.teamname = teamname;
		this.position = position;
		this.playername = playername;
	}
}
