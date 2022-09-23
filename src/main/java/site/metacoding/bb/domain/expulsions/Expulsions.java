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
	private String playersName;
	private Integer teamsId;
	private Integer positionsId;
	private Integer reasonsId;
	private Timestamp createdAt;

	public Expulsions(String playersName, Integer teamsId, Integer positionsId, Integer reasonsId) {
		this.playersName = playersName;
		this.teamsId = teamsId;
		this.positionsId = positionsId;
		this.reasonsId = reasonsId;
	}
}
