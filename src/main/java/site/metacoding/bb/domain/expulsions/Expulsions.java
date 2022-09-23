package site.metacoding.bb.domain.expulsions;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Expulsions {
	private Integer id;
	private String playerName;
	private Integer teamsId;
	private Integer positionId;
	private Integer reasonsId;
	private Timestamp createdAt;

	public Expulsions(String playerName, Integer teamsId, Integer positionId, Integer reasonsId) {
		this.playerName = playerName;
		this.teamsId = teamsId;
		this.positionId = positionId;
		this.reasonsId = reasonsId;
	}
}
