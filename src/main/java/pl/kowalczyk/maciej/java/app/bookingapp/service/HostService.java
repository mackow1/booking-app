package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostUpdateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.HostRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.PropertyRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.HostEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.HostMapper;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class HostService {

    private static final Logger LOGGER = Logger.getLogger(HostRepository.class.getName());

    private final HostRepository hostRepository;
    private final HostMapper hostMapper;
    private final PropertyRepository propertyRepository;

    public HostService(HostRepository hostRepository, HostMapper hostMapper, PropertyRepository propertyRepository) {
        this.hostRepository = hostRepository;
        this.hostMapper = hostMapper;
        this.propertyRepository = propertyRepository;
    }

    public List<Host> list() {
        LOGGER.info("list()");

        List<HostEntity> hostEntityList = hostRepository.findAll();
        List<Host> hosts = hostMapper.fromEntities(hostEntityList);

        LOGGER.info("list(...) = " + hosts);
        return hosts;
    }

    public Host create(Host host) throws HostCreateException {
        LOGGER.info("create(" + host + ")");

        if (host == null) {
            throw new HostCreateException("Host must not be null");
        }

        try {
            HostEntity hostEntity = hostMapper.from(host);
            HostEntity savedHostEntity = hostRepository.save(hostEntity);
            Host savedHost = hostMapper.from(savedHostEntity);

            LOGGER.info("create(...) = " + savedHost);
            return savedHost;
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while saving host: " + host, e);
            throw new HostCreateException("Database access error while saving host:" + host);
        }
    }

    public Host read(Long id) throws HostReadException {
        LOGGER.info("read(" + id + ")");

        Optional<HostEntity> optionalHostEntity = hostRepository.findById(id);
        HostEntity hostEntity = optionalHostEntity.orElseThrow(() -> {
                    LOGGER.log(Level.SEVERE, "Host not found for given id: " + id);
                    return new HostReadException("Host not found for given id: " + id);
                }
        );

        Host host = hostMapper.from(hostEntity);

        LOGGER.info("read(...) = " + host);
        return host;
    }

    public Host update(Host host) throws HostUpdateException {
        LOGGER.info("update(" + host + ")");

        if (host == null) {
            throw new HostUpdateException("Model must not be null");
        }

        try {
            HostEntity hostEntity = hostMapper.from(host);
            HostEntity updatedHostEntity = hostRepository.save(hostEntity);
            Host updatedHost = hostMapper.from(updatedHostEntity);

            LOGGER.info("update(...) = " + updatedHost);
            return updatedHost;
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while updating host: " + host, e);
            throw new HostUpdateException("Database access error while updating host: " + host);
        }
    }

    public void delete(Long id) throws HostDeleteException {
        LOGGER.info("delete(" + id + ")");

        try {
            hostRepository.deleteById(id);
        } catch(DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while deleting host with ID: " + id, e);
            throw new HostDeleteException("Error while deleting host with ID: " + id);
        }

        LOGGER.info("delete(...) = ");
    }
}
