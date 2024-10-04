package com.javabackendakademisi.freelancerMatchingPlatform.controller;

import com.javabackendakademisi.freelancerMatchingPlatform.entity.Bid;
import com.javabackendakademisi.freelancerMatchingPlatform.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @PostMapping
    public Bid createBid(@RequestBody Bid bid) {
        return bidService.saveBid(bid);
    }

    @PutMapping("/{id}")
    public Bid updateBid(@PathVariable Long id, @RequestBody Bid bidDetails) {
        return bidService.updateBid(id, bidDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBid(@PathVariable Long id) {
        bidService.deleteBid(id);
    }
}
