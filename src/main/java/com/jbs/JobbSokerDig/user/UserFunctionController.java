package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.company.SoftOffer;
import com.jbs.JobbSokerDig.service.SoftOfferService;
import com.jbs.JobbSokerDig.service.UserPreferenceService;
import com.jbs.JobbSokerDig.service.UserQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserFunctionController {

    @Autowired
    private UserQualificationService userQualificationService;

    @Autowired
    private UserPreferenceService userPreferenceService;

    @Autowired
    private SoftOfferService softOfferService;

    @PostMapping("/saveUserSettings")
    public String saveUserProfile(HttpServletRequest request, @RequestParam(value = "checkboxName", required = false) String[] qualificationIds) {

        userQualificationService.saveUserQualificationChoice(qualificationIds, request);

        return "redirect:/userEditProfile";
    }

    @PostMapping("/saveUserMustHave")
    public String saveUserMustHave(HttpServletRequest request, @RequestParam(value = "checkboxName", required = false) String[] mustHaves) {

        userPreferenceService.saveUserMustHaves(mustHaves, request);

        return "redirect:/userEditProfile";
    }

    @PostMapping("/saveUserOptionalPreference")
    public String saveUserOptionalPreference(HttpServletRequest request, @RequestParam(value = "checkboxName", required = false) String[] optionalPreferences) {

        userPreferenceService.saveUserOptionalPreferences(optionalPreferences, request);

        return "redirect:/userEditProfile";
    }

    @PostMapping("/getUserOfferChoice")
    public String getUserOfferChoice(@RequestParam(value = "userOfferChoice", required = false) String choice, @RequestParam(value = "soId", required = false) String soId){

        softOfferService.updateUserChoice(choice, soId);

        return "redirect:/userMyOffers";
    }

}
