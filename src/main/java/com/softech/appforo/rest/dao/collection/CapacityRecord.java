package com.softech.appforo.rest.dao.collection;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CapacityRecord {

    @Id
    private UUID capacityRecordId;

    private StoreCampus storeCampus;

    private String description;

    private Integer record;

    private LocalDateTime registerTime;
}
