package site.metacoding.bb.web.dto;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.service.ExpulsionsService;
import site.metacoding.bb.service.ReasonsService;
import site.metacoding.bb.web.dto.request.expulsions.UpdateDto;
import site.metacoding.bb.web.dto.response.CMRespDto;
import site.metacoding.bb.web.dto.response.expulsions.ListExpulsionsDto;
import site.metacoding.bb.web.dto.response.reasons.ListReasonsDto;

@RequiredArgsConstructor
@Controller
public class ExpulsionsController {
	
	private final ExpulsionsService expulsionsService;
	private final ReasonsService reasonsService;
	
	@GetMapping("/expulsions")
	public String findAll(Model model) {
		List<ListExpulsionsDto> expulsions = expulsionsService.findAll();
		model.addAttribute("expulsions", expulsions);
		return "expulsions/listform";
	}
	
	@PutMapping("/expulsions/update")
	public @ResponseBody CMRespDto<?> update(@PathVariable Integer id, @RequestBody UpdateDto updateDto){
		expulsionsService.update(id, updateDto);
		return new CMRespDto<>(1, "퇴출 이유 수정 완료", null);
	}
	
	@GetMapping("/expulsions/updateform")
	public String updateform(Model model) {
		List<ListExpulsionsDto> expulsions = expulsionsService.findAll();
		List<ListReasonsDto> reasons = reasonsService.findAll();
		model.addAttribute("expulsions", expulsions);
		model.addAttribute("reasons", reasons);
		return "expulsions/updateform";
	}
}
