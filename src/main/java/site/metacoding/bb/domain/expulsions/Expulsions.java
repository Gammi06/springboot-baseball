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
	private String teamname;
	private String position;
	private String playername;
	private String reason;
	private Timestamp createdAt;

	public Expulsions(String playername, String reason) {
		this.playername = playername;
		this.reason = reason;
	}
}
