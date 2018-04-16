from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index, name = 'index'),
    url(r'^urlparts/(.+)$', views.read_url, name = 'read_url')
]
