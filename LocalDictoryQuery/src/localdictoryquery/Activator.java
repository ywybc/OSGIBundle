package localdictoryquery;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgichina.demo.dictquery.query.QueryService;
import org.osgichina.demo.localdictquery.impl.LocalDictQueryServiceImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;
    private ServiceRegistration sRegistration=null;
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		//Activator.context = bundleContext;
		sRegistration=bundleContext.registerService(QueryService.class.getName(), new LocalDictQueryServiceImpl(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		//Activator.context = null;
		sRegistration.unregister();
	}

}
