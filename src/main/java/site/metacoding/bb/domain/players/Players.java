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
	private String playerName;
	private Integer teamsId;
	private Integer positionsId;
	private Timestamp createdAt;

	public Players(String playerName, Integer teamsId, Integer positionsId) {
		this.playerName = playerName;
		this.teamsId = teamsId;
		this.positionsId = positionsId;
	}
}
