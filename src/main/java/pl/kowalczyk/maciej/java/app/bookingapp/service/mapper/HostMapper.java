package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.HostEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class HostMapper {

    private static final Logger LOGGER = Logger.getLogger(HostMapper.class.getName());

    public HostEntity from(Host host) {
        LOGGER.info("from(" + host + ")");

        ModelMapper modelMapper = new ModelMapper();
        HostEntity hostEntity = modelMapper.map(host, HostEntity.class);

        LOGGER.info("from(...) = " + hostEntity);
        return hostEntity;
    }

    public Host from(HostEntity hostEntity) {
        LOGGER.info("from(" + hostEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        Host host = modelMapper.map(hostEntity, Host.class);

        LOGGER.info("from(...) = " + host);
        return host;
    }

    public List<Host> fromEntities(List<HostEntity> hostEntities) {
        LOGGER.info("fromEntities(" + hostEntities + ")");

        List<Host> hosts = hostEntities.stream()
                .map(this::from)
                .toList();

        LOGGER.info("fromEntities(...) = " + hosts);
        return hosts;
    }
}
