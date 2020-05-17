package de.autoDrive.MapTileServer.service;

import de.autoDrive.MapTileServer.repository.MapInfoRepository;
import de.autoDrive.MapTileServer.repository.MapTileDataRepository;
import de.autoDrive.MapTileServer.entity.MapTileData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional
public class MapService {

    private final static Logger LOG = LoggerFactory.getLogger(MapService.class);


    @Autowired
    private MapTileDataRepository mapTileDataRepository;

    @Autowired
    private MapInfoRepository mapInfoRepository;


    public byte[] getMap(String name, int level, int x, int y) throws IOException {
        Optional<MapTileData> tile = mapTileDataRepository.findFirstByZoomLevelAndXAndYAndName(level, x, y, name);
        return tile.map(MapTileData::getData).orElse(null);
    }

}
