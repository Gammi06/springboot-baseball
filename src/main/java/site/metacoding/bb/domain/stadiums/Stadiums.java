package site.metacoding.bb.domain.stadiums;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Stadiums {
	private Integer id;
	private String stadiumsName;
	private Timestamp createdAt;
	
	public Stadiums(String stadiumsName) {
		this.stadiumsName = stadiumsName;
	}
}
