package com.javabackendakademisi.freelancerMatchingPlatform.service;

import com.javabackendakademisi.freelancerMatchingPlatform.entity.Bid;
import com.javabackendakademisi.freelancerMatchingPlatform.exception.ResourceNotFoundException;
import com.javabackendakademisi.freelancerMatchingPlatform.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }
    public Bid saveBid(Bid bid) {
        return bidRepository.save(bid);
    }
    public Bid updateBid(Long id, Bid bidDetails) {
        Bid bid = bidRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bid not found with id " + id));

        bid.setBidAmount(bidDetails.getBidAmount());
        bid.setBidStatus(bidDetails.getBidStatus());

        return bidRepository.save(bid);
    }
    public void deleteBid(Long id) {
        Bid bid = bidRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bid not found with id " + id));
        bidRepository.delete(bid);
    }
}
