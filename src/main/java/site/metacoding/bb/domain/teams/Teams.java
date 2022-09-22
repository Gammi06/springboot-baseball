package site.metacoding.bb.domain.teams;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Teams {
	private Integer id;
	private String stadiumname;
	private String teamname;
	private Timestamp createdAt;
	
	public Teams(String stadiumname, String teamname) {
		this.stadiumname = stadiumname;
		this.teamname = teamname;
	}
}
